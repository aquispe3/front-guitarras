package com.example.backendicei.Service;



import com.example.backendicei.Entity.GuitarraEntity;
import com.example.backendicei.dao.IGuitarraDao;
import com.example.backendicei.dto.ResponsePruebaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GuitarraService {
    @Autowired
    private IGuitarraDao iGuitarraPruebaDao;

    public ResponsePruebaDto registrar (GuitarraEntity guitarraPruebaEntity){
        guitarraPruebaEntity.setEstadoId(1000);
        guitarraPruebaEntity.setFechaRegistro(new Date());
        ResponsePruebaDto res = new ResponsePruebaDto();
        iGuitarraPruebaDao.save(guitarraPruebaEntity);
        res.message = "registro guardado";
        res.status = true;
        return res;
    }
    public ResponsePruebaDto modificar (GuitarraEntity guitarraPruebaEntity){
        GuitarraEntity update =  iGuitarraPruebaDao.findById(guitarraPruebaEntity.getGuitarraId()).get();
        update.setCosto(guitarraPruebaEntity.getCosto());
        update.setNombre(guitarraPruebaEntity.getNombre());
        update.setDescripcion(guitarraPruebaEntity.getDescripcion());
        iGuitarraPruebaDao.save(update);
        ResponsePruebaDto res = new ResponsePruebaDto();
        res.message = "Modificacion Exitosa";
        res.status = true;
        return res;
    }
    public ResponsePruebaDto eliminar (Long id){
        GuitarraEntity update =  iGuitarraPruebaDao.findById(id).get();
        update.setEstadoId(1001);
        iGuitarraPruebaDao.save(update);
        ResponsePruebaDto res = new ResponsePruebaDto();
        res.message = "Eliminacion  Exitosa";
        res.status = true;
        return res;
    }
    public ResponsePruebaDto obtenerTodos (){
        List<GuitarraEntity> lstFinal = new ArrayList<>();
        List<GuitarraEntity> lst = iGuitarraPruebaDao.findAll();
        for (GuitarraEntity guitarra:lst) {
            if(guitarra.getEstadoId()==1000)
                lstFinal.add(guitarra);
        }
        ResponsePruebaDto res = new ResponsePruebaDto();
        res.message = "Datos  Encontrados";
        res.status = true;
        res.result = lstFinal;
        return res;
    }

}
