package com.example.backendicei.Service;




import com.example.backendicei.Entity.ClienteEntity;
import com.example.backendicei.dao.IClienteDao;
import com.example.backendicei.dto.ResponsePruebaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private IClienteDao iClientePruebaDao;

    public ResponsePruebaDto registrar (ClienteEntity clientePruebaEntity){
        clientePruebaEntity.setEstadoId(1000);
        clientePruebaEntity.setFechaRegistro(new Date());
        ResponsePruebaDto res = new ResponsePruebaDto();
        iClientePruebaDao.save(clientePruebaEntity);
        res.message = "cliente guardado";
        res.status = true;
        return res;
    }
    public ResponsePruebaDto modificar (ClienteEntity clientePruebaEntity){
        ClienteEntity update =  iClientePruebaDao.findById(clientePruebaEntity.getClienteId()).get();
        update.setNombreCompleto(clientePruebaEntity.getNombreCompleto());
        update.setCorreo(clientePruebaEntity.getCorreo());
        update.setTelefono(clientePruebaEntity.getTelefono());
        iClientePruebaDao.save(update);
        ResponsePruebaDto res = new ResponsePruebaDto();
        res.message = "Modificacion Exitosa";
        res.status = true;
        return res;
    }
    public ResponsePruebaDto eliminar (Long id){
        ClienteEntity update =  iClientePruebaDao.findById(id).get();
        update.setEstadoId(1001);
        iClientePruebaDao.save(update);
        ResponsePruebaDto res = new ResponsePruebaDto();
        res.message = "Eliminacion  Exitosa";
        res.status = true;
        return res;
    }
    public ResponsePruebaDto obtenerTodos (){
        List<ClienteEntity> lstFinal = new ArrayList<>();
        List<ClienteEntity> lst = iClientePruebaDao.findAll();
        for (ClienteEntity guitarra:lst) {
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
