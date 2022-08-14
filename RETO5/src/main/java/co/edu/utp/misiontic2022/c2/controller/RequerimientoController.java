package co.edu.utp.misiontic2022.c2.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.model.dao.AsesorPorCiudadDao;
import co.edu.utp.misiontic2022.c2.model.dao.CompraPorProveedorDao;
import co.edu.utp.misiontic2022.c2.model.dao.ProyectoCasaCampestreDao;
import co.edu.utp.misiontic2022.c2.model.vo.AsesorPorCiudadVo;
import co.edu.utp.misiontic2022.c2.model.vo.CompraPorProveedorVo;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectoCasaCampestreVo;

public class RequerimientoController {
    
    private final AsesorPorCiudadDao asesorPorCiudadDao;
    private final ProyectoCasaCampestreDao proyectoCasaCampestreDao;
    private final CompraPorProveedorDao compraPorProveedorDao;

    public RequerimientoController() {
        this.asesorPorCiudadDao = new AsesorPorCiudadDao();
        this.proyectoCasaCampestreDao = new ProyectoCasaCampestreDao();
        this.compraPorProveedorDao = new CompraPorProveedorDao();
    }

    public ArrayList<AsesorPorCiudadVo> consultarAsesorPorCiudad() throws SQLException{
        return this.asesorPorCiudadDao.listar();
    }
    
    public ArrayList<ProyectoCasaCampestreVo> consultarProyectoCasaCampestre() throws SQLException{
        return this.proyectoCasaCampestreDao.listar();
    }

    public ArrayList<CompraPorProveedorVo> consultarCompraPorProveedor() throws SQLException{
        return this.compraPorProveedorDao.listar();
    }
}
