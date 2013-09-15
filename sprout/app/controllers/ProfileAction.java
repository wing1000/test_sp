package controllers;

import cn.bran.play.JapidResult;
import fengfei.fir.model.Done;
import fengfei.fir.model.Done.Status;
import fengfei.fir.model.Notify;
import fengfei.fir.service.JpegExifWriter;
import fengfei.fir.service.JpegProcess;
import fengfei.fir.service.impl.DefaultJpegProcess;
import fengfei.fir.service.impl.SqlJpegExifWriter;
import fengfei.fir.utils.BASE64;
import fengfei.fir.utils.Path;
import fengfei.forest.database.DataAccessException;
import fengfei.ucm.entity.photo.PhotoSet;
import fengfei.ucm.entity.profile.*;
import fengfei.ucm.repository.PhotoManageRepository;
import fengfei.ucm.repository.ProfileRepository;
import fengfei.ucm.repository.UserRepository;
import fengfei.ucm.repository.impl.SqlPhotoManageRepository;
import fengfei.ucm.repository.impl.SqlProfileRepository;
import fengfei.ucm.repository.impl.SqlUserRepository;
import japidviews.Application.profile.*;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import org.imgscalr.Scalr;
import play.Logger;
import play.modules.router.Any;
import play.modules.router.Post;
import play.mvc.With;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@With(Secure.class)
public class ProfileAction extends Admin {

    static UserRepository userService = new SqlUserRepository();
    static ProfileRepository profileRepository = new SqlProfileRepository();
    static JpegExifWriter jpegExifWrite = new SqlJpegExifWriter();
    static JpegProcess jpegProcess = new DefaultJpegProcess();

    public static void profile() {

        Integer idUser = currentUserId();
        System.out.println("user: " + idUser);
        try {

            User user = userService.getUser(idUser);
            if (user == null) {
                user = new User();
            }
            UserPwd up = userService.getUserPwd(idUser);
            user.userName = up.userName;
            user.email = up.email;
            if (!user.isHeadPhoto) {
                user.headPath = user.gender == 1 ? "/public/photo/head/m.jpg"
                        : "/public/photo/head/f.jpg";
            } else {
                String path = Path.getHeadPhotoDownloadPath(user.idUser);
                user.headPath = path;
            }

            throw new JapidResult(new Profile().render(user));
        } catch (Exception e) {
            Logger.error(e, "profile index error.");
            throw new JapidResult(new Profile().render(new User()));
        }

    }

    public static void profileDone() {
        String userName = params.get("username");
        String email = params.get("email");
        String niceName = params.get("nicename");
        String realName = params.get("realName");
        String country = params.get("country");
        String state = params.get("state");
        String city = params.get("city");
        String about = params.get("about");
        String sgender = params.get("gender");
        Integer gender = Integer.parseInt(sgender);
        String birthday = params.get("birthday");
        String phone = params.get("phone");
        Integer idUser = currentUserId();
        Map<String, String> contents = params.allSimple();
        String userPhoto = MapUtils.getString(contents, "user_photo");
        User user = new User(
                idUser,
                userName,
                email,
                realName,
                birthday,
                gender,
                phone,
                about,
                city,
                state,
                country);
        user.isHeadPhoto = userPhoto != null && !"".equals(userPhoto);
        user.setNiceName(niceName);
        if (idUser == null) {
            flash.put("error", "Please login!");
            throw new JapidResult(new Profile().render(user));
        }

        user.setIdUser(idUser);

        try {

            int updated = userService.saveUser(user);
            if (updated > 0) {
                if (niceName != null && !"".equals(niceName)) {
                    session.put(SESSION_USER_NAME_KEY, niceName);
                }
            }
            //throw new JapidResult(new Profile().render(user));
        } catch (Exception e) {
            Logger.error(e, "add profile error.");
            // throw new JapidResult(new Profile().render(new User()));

        }
        profile();

    }

    @Post("/settings/profile/crop/done")
    public static void userPhotoCrop() {
        Map<String, String> contents = params.allSimple();
        int x1 = MapUtils.getIntValue(contents, "x1");
        int y1 = MapUtils.getIntValue(contents, "y1");
        int x2 = MapUtils.getIntValue(contents, "x2");
        int y2 = MapUtils.getIntValue(contents, "y2");
        int w = MapUtils.getIntValue(contents, "w");
        int h = MapUtils.getIntValue(contents, "h");
        Integer idUser = currentUserId();
        String jpgPath = Path.getHeadPhotoUploadPath(idUser);
        File jpegFile = new File(jpgPath);
        System.out.println(jpgPath);
        System.out.println(contents);
        if (jpegFile.exists()) {

            try {
                BufferedImage src = javax.imageio.ImageIO.read(jpegFile);
                BufferedImage dest = Scalr.crop(src, x1, y1, w, h, Scalr.OP_ANTIALIAS);
                if (w > 200) {
                    dest = Scalr.resize(dest, 200, Scalr.OP_ANTIALIAS);
                }
                String jpgPath1 = Path.getHeadPhotoUploadPath(idUser, 1);
                File jpegFile1 = new File(jpgPath1);
                ImageIO.write(dest, "JPEG", jpegFile1);
            } catch (IOException e) {

                Logger.error(e, "user photo crop error.");
            }

        }
        Done done = new Done(Status.Success);
        String path0 = Path.getHeadPhotoDownloadPath(idUser, 0);
        done.put("path0", path0);
        String path1 = Path.getHeadPhotoDownloadPath(idUser, 1);
        done.put("path1", path1);
        renderJSON(done);

    }

    /**
     * {"success": false, "error": "error message to display", "preventRetry": true}
     *
     * @param qqfile
     */
    public static void headUpload(File qqfile) {
        System.out.println(qqfile);
        System.out.println(params.allSimple());
        Done done = new Done(Status.Success);
        try {
            Integer idUser = currentUserId();

            String jpgPath = Path.getHeadPhotoUploadPath(idUser);
            File jpegFile = new File(jpgPath);
            if (jpegFile.exists()) {
                jpegFile.delete();
            } else {
                jpegFile.getParentFile().mkdirs();
            }

            BufferedImage src = javax.imageio.ImageIO.read(qqfile);
            int w = src.getWidth();
            int h = src.getHeight();
            System.out.printf("%d %d \n", w, h);
            if (w > 700 || h > 700) {
                BufferedImage dest = Scalr.resize(src, 700, 700, Scalr.OP_ANTIALIAS);

                ImageIO.write(dest, "JPEG", new File(jpgPath));

            } else {
                FileUtils.moveFile(qqfile, jpegFile);
            }
            String jpgPath1 = Path.getHeadPhotoUploadPath(idUser, 1);
            File jpegFile1 = new File(jpgPath1);
            if (jpegFile1.exists()) {
                jpegFile1.delete();
            }
            jpegProcess.cropAndResize(jpgPath, jpgPath1, 200);
            boolean updated = userService.updateHeadPhoto(idUser, true);
            done.put("isHeadPhoto", true);
            if (updated) {
                done.setStatus(Status.Success);
                String path0 = Path.getHeadPhotoDownloadPath(idUser, 0);
                done.put("path0", path0);
                String path1 = Path.getHeadPhotoDownloadPath(idUser, 1);
                done.put("path1", path1);
            } else {
                done.setStatus(Status.Fail);
            }

        } catch (Exception e) {
            done.setStatus(Status.Error);
            Logger.error(e, "add profile error.");
        }

        renderJSON(done);

    }

    public static void password() {
        throw new JapidResult(new Password().render());
    }

    public static void passwordDone() {
        String oldPwd = params.get("oldPassword");
        String newPwd = params.get("newPassword");
        String reNewPwd = params.get("reNewPassword");
        if (!newPwd.equals(reNewPwd)) {
            flash.put("error", i18n("password.error.mismatched"));
        } else {
            Integer idUser = currentUserId();
            if (idUser == null) {
                flash.put("error", i18n("no.login"));
                idUser = 1;
            }
            try {
                int updated = userService.updatePassword(
                        idUser,
                        BASE64.encrypt(oldPwd),
                        BASE64.encrypt(newPwd));
                if (updated == -1) {
                    flash.error(i18n("password.error.old.mismatched"));
                } else if (updated == 0) {
                    flash.error(i18n("password.error.new.no.updated"));
                } else {
                    flash.success(i18n("password.message.updated"));
                }

            } catch (Exception e) {
                Logger.error(e, i18n("password.message.updated"));
                flash.error(i18n("password.error.new.no.updated"));
            }
        }
        throw new JapidResult(new Password().render());
    }

    public static void notification() throws Exception {
        Integer idUser = currentUserId();
        long value = profileRepository.getNotifyValue(idUser);

//        boolean[] checks = new boolean[64];
        String bStr = Long.toBinaryString(value);
        String padding = "0000000000000000000000000000000000000000000000000000000000000000";
        String result = padding + Long.toBinaryString(value);
        bStr = result.substring(result.length() - 64, result.length());
//        System.out.println(bStr);
//        for (int i = 1; i <= bStr.length(); i++) {
//            int index = bStr.length() - i;
//            checks[i-1] = '1' == bStr.charAt(index);
//        }

        throw new JapidResult(new Notification().render(bStr));
    }


    public static void notificationDone() throws Exception {
        Map<String, String> contents = params.allSimple();
        List<Notify> notifies = new ArrayList<>();
        for (byte i = 1; i <= 11; i++) {
            String key = "notify" + i;
            byte value = MapUtils.getByteValue(contents, key, (byte) 0);
            notifies.add(new Notify(i, value > 0));
        }
        Integer idUser = currentUserId();

        boolean updated = profileRepository.saveNotifies(idUser, notifies);
        notification();
    }

    @Any("/settings/socialmedia")
    public static void socialMedia() throws Exception {
        UserSocial userSocial = profileRepository.getUserSocial(currentUserId());
        if (userSocial == null) {
            userSocial = new UserSocial();
        }
        throw new JapidResult(new SocialMedia().render(userSocial));
    }

    @Post("/settings/socialmedia/done")
    public static void socialMediaDone() throws Exception {

        Map<String, String> map = params.allSimple();
        UserSocial userSocial = new UserSocial();
        userSocial.idUser = currentUserId();
        userSocial.web_site = MapUtils.getString(map, "	web_site");
        userSocial.weibo = MapUtils.getString(map, "weibo");
        userSocial.qq = MapUtils.getString(map, "qq");
        userSocial.qq_weibo = MapUtils.getString(map, "qq_weibo");
        userSocial.douban = MapUtils.getString(map, "douban");
        userSocial.twitter = MapUtils.getString(map, "twitter");
        userSocial.facebook = MapUtils.getString(map, "facebook");
        userSocial.flickr = MapUtils.getString(map, "flickr");
        userSocial.blog = MapUtils.getString(map, "blog");
        userSocial.skype = MapUtils.getString(map, "skype");
        userSocial.fengniao = MapUtils.getString(map, "fengniao");
        userSocial.renren = MapUtils.getString(map, "renren");
        int updated = profileRepository.saveUserSocial(userSocial);

        //web_site, weibo, qq, qq_weibo, douban, twitter, facebook, flickr, blog, skype, fengniao, renren

        socialMedia();
    }

    public static void camera() {
        Integer idUser = currentUserId();
        if (idUser == null) {
            flash.error(i18n("no.login"));
            idUser = 1;
        }
        try {
            List<Camera> cameras = profileRepository.selectCamerasForSorted(idUser);

            throw new JapidResult(new Equipment().render(cameras));
        } catch (DataAccessException e) {
            flash.error(i18n("server.inner.error"));
            Logger.error(e, "camera error.");
            throw new JapidResult(new Equipment().render(new ArrayList<Camera>()));
        }

    }

    public static void cameraDone() {
        String[] cameras = params.getAll(Camera.TypeCamera);
        String[] lenses = params.getAll(Camera.TypeLens);
        String[] tripods = params.getAll(Camera.TypeTripod);
        String[] filters = params.getAll(Camera.TypeFilter);
        int idUser = currentUserId();
        List<Camera> models = new ArrayList<>();
        try {
            addCamera(models, idUser, cameras, Camera.TypeCamera);
            addCamera(models, idUser, lenses, Camera.TypeLens);
            addCamera(models, idUser, tripods, Camera.TypeFilter);
            addCamera(models, idUser, filters, Camera.TypeTripod);
            profileRepository.addCamera(models, idUser);
            camera();
        } catch (DataAccessException e) {
            Logger.error(e, "camera error.");
            throw new JapidResult(new Equipment().render(new ArrayList<Camera>()));
        }

    }

    private static void addCamera(List<Camera> models, int idUser, String[] cameras, String type) {
        if (cameras == null || cameras.length == 0) {
            return;
        }
        for (int i = 0; i < cameras.length; i++) {
            Camera camera = new Camera(idUser, cameras[i], type);
            models.add(camera);
        }
    }

    public static void account() {
        throw new JapidResult(new Account().render());
    }

    public static void accountDone() {
        throw new JapidResult(new Account().render());
    }

    @Any("/settings/license")
    public static void license() throws Exception {
        byte value = profileRepository.getDefaultLicense(currentUserId());
        throw new JapidResult(new License().render(value));
    }

    @Post("/settings/license/done")
    public static void licenseDone() throws Exception {
        Map<String, String> map = params.allSimple();
        String by = MapUtils.getString(map, "by");
        String c = MapUtils.getString(map, "c");
        String[] bys = new String[3];
        String licenseKey = "by";
        if ("nc".equals(c)) {
            licenseKey += "-nc";
        }
        if ("nd".equals(by) || "sa".equals(by)) {
            licenseKey += "-" + by;
        }
        System.out.println("------------: " + licenseKey);
        LicenseType licenseType = LicenseType.findByKey(licenseKey);
        profileRepository.saveDefaultLicense(currentUserId(), licenseType.getValue());

        license();
    }

    static PhotoManageRepository photoManage = new SqlPhotoManageRepository();

    @Any("/photo/manage")
    public static void manage() {
        Integer idUser = currentUserId();
        try {
            List<PhotoSet> photoSets = photoManage.selectUserSets(idUser);
            throw new JapidResult(new PhotoManage().render(photoSets));
        } catch (DataAccessException e) {
            throw new JapidResult(new PhotoManage().render(new ArrayList<PhotoSet>()));
        }
    }

}
