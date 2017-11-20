package com.ismek.rest;

import com.ismek.dao.ActiveLocationInfoDAO;
import com.ismek.dto.BaseReturn;
import com.ismek.entity.ActiveLocationInfo;
import org.jboss.logging.annotations.Pos;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by İhsan on 11/20/2017.
 */
@Path("activelocationinfo")
public class ActiveLocationInfoRestService {

    ActiveLocationInfoDAO activeLocationInfoDAO = new ActiveLocationInfoDAO();

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public BaseReturn<List<ActiveLocationInfo>> findAll() {
        List<ActiveLocationInfo> list = activeLocationInfoDAO.findAll();
        if (list != null) {
            return new BaseReturn<List<ActiveLocationInfo>>(true, "Tüm aktif konum bilgileri bulundu.", list);
        } else {
            return new BaseReturn<List<ActiveLocationInfo>>(false, "Hiçbir aktif konum bilgisi bulunamadı.", null);
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public BaseReturn<ActiveLocationInfo> findByActiveLocationId(@PathParam("id") long id) {
        ActiveLocationInfo object = activeLocationInfoDAO.findById(id);
        if (object != null) {
            return new BaseReturn<ActiveLocationInfo>(true, "Aktif konum bilgileri bulundu.", object);
        } else {
            return new BaseReturn<ActiveLocationInfo>(false, "Aktif konum bilgilerine erişilemedi.", null);
        }
    }

    @GET
    @Path("/find/{driverId}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public BaseReturn<ActiveLocationInfo> findByDriverId(@PathParam("driverId") long id) {
        ActiveLocationInfo object = activeLocationInfoDAO.findByDriverId(id);
        if (object != null) {
            return new BaseReturn<ActiveLocationInfo>(true, "Aktif konum bilgileri bulundu.", object);
        } else {
            return new BaseReturn<ActiveLocationInfo>(false, "Aktif konum bilgilerine erişilemedi.", null);
        }
    }

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public BaseReturn<String> save(ActiveLocationInfo activeLocationInfo) {
        boolean result = activeLocationInfoDAO.save(activeLocationInfo);
        if (result) {
            return new BaseReturn<String>(true, "Aktif konum bilgileri eklendi.", "");
        } else {
            return new BaseReturn<String>(false, "Aktif konum bilgileri eklenemedi.", "");
        }
    }

    @GET
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public BaseReturn<String> delete(@PathParam("id") long id) {
        boolean result = activeLocationInfoDAO.delete(id);
        if (result) {
            return new BaseReturn<String>(true, "Aktif konum bilgileri silindi.", "");
        } else {
            return new BaseReturn<String>(false, "Aktif konum bilgileri silinemedi.", "");
        }
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public BaseReturn<String> update(@PathParam("id") long id, ActiveLocationInfo activeLocationInfo) {
        boolean result = activeLocationInfoDAO.update(activeLocationInfo);
        if (result) {
            return new BaseReturn<String>(true, "Aktif konum bilgileri güncellendi.", "");
        } else {
            return new BaseReturn<String>(false, "Aktif konum bilgileri güncellenemedi.", "");
        }
    }


}
