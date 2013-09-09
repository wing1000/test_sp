package fengfei.ucm.dao.transducer;

import java.sql.ResultSet;
import java.sql.SQLException;

import fengfei.fir.utils.AppUtils;
import fengfei.forest.database.dbutils.Transducer;
import fengfei.ucm.entity.photo.PhotoAccess;
import fengfei.ucm.entity.photo.PhotoAccess.AccessType;

public class PhotoAccessTransducer implements Transducer<PhotoAccess> {

    @Override
    public PhotoAccess transform(ResultSet rs) throws SQLException {
        Integer idUser = rs.getInt("id_user");
        long idPhoto = rs.getLong("id_photo");
        long id = rs.getLong("id");
        int updateAt = rs.getInt("at");
        int cancel = rs.getInt("cancel");
        int iip=rs.getInt("ip");
        int itype = rs.getInt("type");
        AccessType type = AccessType.valueOf(itype);
        String title = rs.getString("title");
        String niceName = rs.getString("nice_name");
        byte category = rs.getByte("category");
        PhotoAccess p = new PhotoAccess(id, idPhoto, idUser, updateAt, cancel,  type);
        p.title = title;
        p.niceName = niceName;
        p.category = category;
        p.iip=iip;
        p.ip=AppUtils.int2ip(iip);
        return p;
    }

}