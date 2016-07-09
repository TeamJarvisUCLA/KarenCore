package karen.core.test;

import java.util.ArrayList;
import java.util.List;

import lights.seguridad.dto.IconSclass;
import lights.seguridad.dto.NodoMenu;
import lights.seguridad.dto.Operacion;
import lights.seguridad.dto.Usuario;
import lights.seguridad.dto.Vista;
import lights.seguridad.enums.OperacionEnum;
import lights.seguridad.enums.TipoNodoMenuEnum;
import lights.seguridad.enums.helper.OperacionHelper;
import lights.seguridad.payload.response.PayloadNodoMenuResponse;
import lights.seguridad.payload.response.PayloadOperacionResponse;
import lights.seguridad.payload.response.PayloadUsuarioResponse;

public class SecurityService {
//
//	public static PayloadNodoMenuResponse getNodoMenuesPorUsuario() {
//		PayloadNodoMenuResponse payloadNodoMenu = new PayloadNodoMenuResponse();
//		
//		NodoMenu root = new NodoMenu();
//		root.setNombre("Menu");
//		root.setIdNodoMenu(0);
//		root.setTipoNodoMenuEnum(TipoNodoMenuEnum.RAIZ);
//		
//		List<NodoMenu> hRoot = new ArrayList<NodoMenu>();
//		
//		List<NodoMenu> hInventarioEquipos = new ArrayList<NodoMenu>();
//		List<NodoMenu> hGestionEquipos = new ArrayList<NodoMenu>();
//		List<NodoMenu> hGestionServicios = new ArrayList<NodoMenu>();
//		
//		List<NodoMenu> hTestTecnologicos = new ArrayList<NodoMenu>();
//		
//		IconSclass iconSclass = new IconSclass();
//		iconSclass.setNombre("fa fa-television");
//		
//		Vista vista = new Vista();
//		vista.setNombre("vista/principalAstronauta.zul");
//	
////			NodoMenu tInventarioEquipos = new NodoMenu();
////			tInventarioEquipos.setNombre("Menu 1");
////			tInventarioEquipos.setFkIconSclass(iconSclass);
////			tInventarioEquipos.setTipoNodoMenuEnum(TipoNodoMenuEnum.CARPETA);
////			
////				NodoMenu tGestionEquipos = new NodoMenu();
////				tGestionEquipos.setNombre("GestiÃ³n de Equipos");
////				tGestionEquipos.setFkIconSclass(iconSclass);
////				tGestionEquipos.setTipoNodoMenuEnum(TipoNodoMenuEnum.CARPETA);
////				
////					NodoMenu tActualizacionEquipos = new NodoMenu();
////					tActualizacionEquipos.setNombre("ActualizaciÃ³n de Equipos");
////					tActualizacionEquipos.setFkIconSclass(iconSclass);
////					tActualizacionEquipos.setTipoNodoMenuEnum(TipoNodoMenuEnum.TRANSACCION);
////					tActualizacionEquipos.setFkVista(vista);
////					tActualizacionEquipos.setIdNodoMenu(7);
////					hGestionEquipos.add(tActualizacionEquipos);
////					
////					NodoMenu tAsignacionEquipos = new NodoMenu();
////					tAsignacionEquipos.setNombre("AsignaciÃ³n de Equipos");
////					tAsignacionEquipos.setFkIconSclass(iconSclass);
////					tAsignacionEquipos.setTipoNodoMenuEnum(TipoNodoMenuEnum.TRANSACCION);
////					tAsignacionEquipos.setFkVista(vista);
////					tAsignacionEquipos.setIdNodoMenu(8);
////					hGestionEquipos.add(tAsignacionEquipos);
////					
////					NodoMenu tDevolucionEquipos = new NodoMenu();
////					tDevolucionEquipos.setNombre("Test");
////					tDevolucionEquipos.setFkIconSclass(iconSclass);
////					tDevolucionEquipos.setTipoNodoMenuEnum(TipoNodoMenuEnum.TRANSACCION);
////					Vista vistaTest = new Vista();
////					vistaTest.setNombre("vista/test.zul");
////					tDevolucionEquipos.setFkVista(vistaTest);
////					tDevolucionEquipos.setIdNodoMenu(9);
////					hGestionEquipos.add(tDevolucionEquipos);
////					
////					tGestionEquipos.setHijos(hGestionEquipos);
////			
////				hInventarioEquipos.add(tGestionEquipos);
////				
////				NodoMenu tGestionServicios = new NodoMenu();
////				tGestionServicios.setNombre("Luna");
////				tGestionServicios.setFkIconSclass(iconSclass);
////				tGestionServicios.setTipoNodoMenuEnum(TipoNodoMenuEnum.CARPETA);
////				
////					NodoMenu tActualizacionServicios = new NodoMenu();
////					tActualizacionServicios.setNombre("Astronautas");
////					tActualizacionServicios.setFkIconSclass(iconSclass);
////					tActualizacionServicios.setTipoNodoMenuEnum(TipoNodoMenuEnum.TRANSACCION);
////					tActualizacionServicios.setFkVista(vista);
////					tActualizacionServicios.setIdNodoMenu(11);
////					hGestionServicios.add(tActualizacionServicios);
////			
////					tGestionServicios.setHijos(hGestionServicios);
////					
////				hInventarioEquipos.add(tGestionServicios);	
////		
////			tInventarioEquipos.setHijos(hInventarioEquipos);
////			
////		hRoot.add(tInventarioEquipos);
//			
//			NodoMenu tTestTecnologicos = new NodoMenu();
//			tTestTecnologicos.setNombre("Luna");
//			tTestTecnologicos.setFkIconSclass(iconSclass);
//			tTestTecnologicos.setTipoNodoMenuEnum(TipoNodoMenuEnum.CARPETA);
//			
//				NodoMenu tEnviarTest = new NodoMenu();
//				tEnviarTest.setNombre("Astronautas");
//				tEnviarTest.setFkIconSclass(iconSclass);
//				tEnviarTest.setTipoNodoMenuEnum(TipoNodoMenuEnum.TRANSACCION);
//				tEnviarTest.setFkVista(vista);
//				tEnviarTest.setIdNodoMenu(20);
//				hTestTecnologicos.add(tEnviarTest);
//			
//			tTestTecnologicos.setHijos(hTestTecnologicos);
//			
//		hRoot.add(tTestTecnologicos);
//		
//			
//				
//		root.setHijos(hRoot);
//		
//		payloadNodoMenu.setInformacion("resultado", "OK");
//		
//		List<NodoMenu> rootNodoMenu = new ArrayList<NodoMenu>();
//		rootNodoMenu.add(root);
//		
//		payloadNodoMenu.setObjetos(rootNodoMenu);
//
//		return payloadNodoMenu;
//	}
//	
//	public static PayloadUsuarioResponse buscarUsuarios(Integer page) {
//		PayloadUsuarioResponse payloadUsuarioResponse = new PayloadUsuarioResponse();
//		
//		List<Usuario> usuarios = new ArrayList<Usuario>();
//		
//		if (page == 1) {
//			usuarios.add(new Usuario("", "j@j.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "x@x.com", Usuario.INACTIVO));
//			usuarios.add(new Usuario("", "y@y.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "w@w.com", Usuario.INACTIVO));
//			usuarios.add(new Usuario("", "c@c.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "c@c.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "c@c.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "c@c.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "c@c.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "c@c.com", Usuario.ACTIVO));
//			
//			payloadUsuarioResponse.setObjetos(usuarios);
//			
//			payloadUsuarioResponse.setInformacion("resultado", "OK");
//			payloadUsuarioResponse.setInformacion("totalPaginas", 3);
//			payloadUsuarioResponse.setInformacion("page", 1);
//			payloadUsuarioResponse.setInformacion("totalElementos", 10);
//			payloadUsuarioResponse.setInformacion("cantidadRegistrosDB", 22);
//			payloadUsuarioResponse.setInformacion("count", 10);
//			payloadUsuarioResponse.setInformacion("lastPage", false);
//			payloadUsuarioResponse.setInformacion("firstPage", true);
//			
//			return payloadUsuarioResponse;
//		}
//		
//		if (page == 2) {
//			usuarios.add(new Usuario("", "yyyy@j.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "yyyy@x.com", Usuario.INACTIVO));
//			usuarios.add(new Usuario("", "yyyy@y.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "zzzz@w.com", Usuario.INACTIVO));
//			usuarios.add(new Usuario("", "zzzz@c.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "zzzz@c.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "zzzz@c.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "222@c.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "2@c.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "2c@c.com", Usuario.ACTIVO));
//			
//			payloadUsuarioResponse.setObjetos(usuarios);
//			
//			payloadUsuarioResponse.setInformacion("resultado", "OK");
//			payloadUsuarioResponse.setInformacion("totalPaginas", 3);
//			payloadUsuarioResponse.setInformacion("page", 2);
//			payloadUsuarioResponse.setInformacion("totalElementos", 10);
//			payloadUsuarioResponse.setInformacion("cantidadRegistrosDB", 22);
//			payloadUsuarioResponse.setInformacion("count", 10);
//			payloadUsuarioResponse.setInformacion("lastPage", false);
//			payloadUsuarioResponse.setInformacion("firstPage", false);
//			
//			return payloadUsuarioResponse;
//		}
//		
////		if (page == 3) {
//			usuarios.add(new Usuario("", "yyyy@j.com", Usuario.ACTIVO));
//			usuarios.add(new Usuario("", "yyyy@x.com", Usuario.INACTIVO));
//			
//			payloadUsuarioResponse.setObjetos(usuarios);
//			
//			payloadUsuarioResponse.setInformacion("resultado", "OK");
//			payloadUsuarioResponse.setInformacion("totalPaginas", 3);
//			payloadUsuarioResponse.setInformacion("page", 3);
//			payloadUsuarioResponse.setInformacion("totalElementos", 2);
//			payloadUsuarioResponse.setInformacion("cantidadRegistrosDB", 22);
//			payloadUsuarioResponse.setInformacion("count", 10);
//			payloadUsuarioResponse.setInformacion("lastPage", true);
//			payloadUsuarioResponse.setInformacion("firstPage", false);
//			
//			return payloadUsuarioResponse;
////		}
//	}
//	
////	public static RPayloadNodoMenu getTodasNodoMenues() {
////		//Buscando roles
////		RPayloadRol rPayloadRol = RolService.consultarRols();
////		
////		if (!"OK".equals(rPayloadRol.getInformacion("resultado"))) {
////			RPayloadNodoMenu payload = new RPayloadNodoMenu();
////			
////			payload.putInformacion("resultado", rPayloadRol.getInformacion("resultado"));
////			payload.putInformacion("mensaje", rPayloadRol.getInformacion("mensaje"));
////			
////			return payload;
////		}
////		
////		Map<Integer, Rol> roles = new HashMap<Integer, Rol>();
////		
////		for(Rol rol: rPayloadRol.getData()) {
////			roles.put(rol.getIdRol(), rol);
////		}
////		
////		//Fin busqueda roles
////		NodoMenu menu = new NodoMenu();
////		menu.setNombre("Menu");
////		menu.setIdNodoMenu(0);
////		menu.setTipoNodoMenuEnum(TipoNodoMenuEnum.RAIZ);
////		
////		RPayloadNodoMenu payload = getNodoMenuesPorPadre(menu, roles);
////		
////		if (!"OK".equals(payload.getInformacion("resultado"))) {
////			return payload;
////		}
////		
////		menu.setHijos(payload.getData());
////		
////		List<NodoMenu> hRoot = new ArrayList<NodoMenu>();
////		hRoot.add(menu);
////		
////		payload.setData(hRoot);
////		
////		return payload;
////	}
////	
////	public static RPayloadNodoMenu getNodoMenuesPorPadre(NodoMenu padre, Map<Integer, Rol> roles) {
////		
////		
////		RPayloadNodoMenu payload = NodoMenuService.consultarNodoMenuPorCriterios(-1, padre.getIdNodoMenu(), "*", -1, "*", "*");
////		
////		if (!"OK".equals(payload.getInformacion("resultado"))) {
////			return payload;
////		}
////		
////		List<NodoMenu> transaccionesHijosFinal = new ArrayList<NodoMenu>();
////		
////		for(NodoMenu transaccionHijo: payload.getData()) {
////			if (transaccionHijo.getTipoNodoMenuEnum().equals(TipoNodoMenuEnum.TRANSACCION)) {
////				
////				RPayloadPermisoSeguridad rPayloadPermisoSeguridad = PermisoSeguridadService.consultarPermisoSeguridadPorCriterios(-1, transaccionHijo.getIdNodoMenu(), -1, -1);
////				
////				Map<Integer, Integer> operacionesRegistradas = new HashMap<Integer, Integer>();
////				List<Operacion> operaciones = new ArrayList<Operacion>();
////				
////				if ("OK".equals(rPayloadPermisoSeguridad.getInformacion("resultado"))) {
////					
////					for(PermisoSeguridad permisoSeguridad: rPayloadPermisoSeguridad.getData()) {
////						
////						if (operacionesRegistradas.containsKey(permisoSeguridad.getOperacion())) {
////							Integer posicion = operacionesRegistradas.get(permisoSeguridad.getOperacion());
////							
////							operaciones.get(posicion).getRoles().add(roles.get(permisoSeguridad.getFkRol().getIdRol()));
////							continue;
////						}
////						//!operacionesRegistradas.containsKey(permisoSeguridad.getOperacion())
////						Operacion operacion = OperacionGridHelper.getPorId(permisoSeguridad.getOperacion());
////						
////						operacion.getRoles().add(roles.get(permisoSeguridad.getFkRol().getIdRol()));
////						
////						operaciones.add(operacion);
////						
////						operacionesRegistradas.put(permisoSeguridad.getOperacion(), operaciones.size() - 1);
////					}
////					
////				}
////				
////				transaccionHijo.setOperaciones(operaciones);
////				
////				transaccionesHijosFinal.add(transaccionHijo);
////				
////				continue;
////			}
////			
////			//transaccionHijo.getTipoNodoMenuEnum().equals(TipoNodoMenuEnum.CARPETA)
////			
////			RPayloadNodoMenu payloadHijo = getNodoMenuesPorPadre(transaccionHijo, roles);
////			
////			if (!"OK".equals(payloadHijo.getInformacion("resultado"))) {
////				return payloadHijo;
////			}
////			
////			transaccionHijo.setHijos(payloadHijo.getData());
////			
////			transaccionesHijosFinal.add(transaccionHijo);
////		}
////		
////		Collections.sort(transaccionesHijosFinal);
////		
////		payload.setData(transaccionesHijosFinal);
////		
////		return payload;
////	}
////
//	public static PayloadOperacionResponse getOperacionesByUsuarioAndNodoMenu() {
//		PayloadOperacionResponse payloadOperacion = new PayloadOperacionResponse();
//		
//		List<Operacion> operaciones = new ArrayList<Operacion>();
//
//		operaciones.add(OperacionHelper.getPorType(OperacionEnum.ELIMINAR));
//		operaciones.add(OperacionHelper.getPorType(OperacionEnum.INCLUIR));
//		operaciones.add(OperacionHelper.getPorType(OperacionEnum.MODIFICAR));
//		operaciones.add(OperacionHelper.getPorType(OperacionEnum.CONSULTAR));
//		operaciones.add(OperacionHelper.getPorType(OperacionEnum.CUSTOM1));
//		operaciones.add(OperacionHelper.getPorType(OperacionEnum.CUSTOM2));
//		operaciones.add(OperacionHelper.getPorType(OperacionEnum.CUSTOM3));
//		operaciones.add(OperacionHelper.getPorType(OperacionEnum.CUSTOM4));
//
//		payloadOperacion.setObjetos(operaciones);
//		
//		payloadOperacion.setInformacion("resultado", "OK");
//		
//		return payloadOperacion;
//	}
////
////	public static RPayloadNodoMenu getNodoMenues() {
////		RPayloadNodoMenu payloadNodoMenu = new RPayloadNodoMenu();
////		
////		List<NodoMenu> hRoot = new ArrayList<NodoMenu>();
////
////		NodoMenu tDashboard = new NodoMenu();
////		tDashboard.setNombre("Dashboard");
////		tDashboard.setIconSclass("z-icon-dashboard");
////		tDashboard.setTipoNodoMenuEnum(TipoNodoMenuEnum.TRANSACCION);
////		tDashboard.setArchivoZul("listbox.zul");
////		hRoot.add(tDashboard);
////
////		NodoMenu tTypography = new NodoMenu();
////		tTypography.setNombre("Typography");
////		tTypography.setIconSclass("z-icon-text-width");
////		tTypography.setTipoNodoMenuEnum(TipoNodoMenuEnum.TRANSACCION);
////		tTypography.setArchivoZul("formulario.zul");
////		hRoot.add(tTypography);
////
////		NodoMenu tUiElement = new NodoMenu();
////		tUiElement.setNombre("UI Elements");
////		tUiElement.setIconSclass("z-icon-desktop");
////		tUiElement.setTipoNodoMenuEnum(TipoNodoMenuEnum.CARPETA);
////		hRoot.add(tUiElement);
////		
////		payloadNodoMenu.setData(hRoot);
////		payloadNodoMenu.putInformacion("resultado", "OK");
////
////		return payloadNodoMenu;
////	}
////
////	public static RPayloadNodoMenu geNodoMenuesPaginacion(int cantidad, int pagina) {
////		RPayloadNodoMenu payloadNodoMenu = new RPayloadNodoMenu();
////		List<NodoMenu> hRoot = new ArrayList<NodoMenu>();
////		
////		if (pagina == 1) {
////			NodoMenu tDashboard = new NodoMenu();
////			tDashboard.setNombre("Dashboard");
////			tDashboard.setIconSclass("z-icon-dashboard");
////			tDashboard.setTipoNodoMenuEnum(TipoNodoMenuEnum.TRANSACCION);
////			tDashboard.setArchivoZul("listbox.zul");
////			hRoot.add(tDashboard);
////			payloadNodoMenu.putInformacion("primeraPagina", true);
////			payloadNodoMenu.putInformacion("ultimaPagina", false);
////		}
////		if (pagina == 2) {
////			NodoMenu tTypography = new NodoMenu();
////			tTypography.setNombre("Typography");
////			tTypography.setIconSclass("z-icon-text-width");
////			tTypography.setTipoNodoMenuEnum(TipoNodoMenuEnum.TRANSACCION);
////			tTypography.setArchivoZul("botones.zul");
////			hRoot.add(tTypography);
////			payloadNodoMenu.putInformacion("primeraPagina", false);
////			payloadNodoMenu.putInformacion("ultimaPagina", false);
////
////		}
////		if (pagina == 3) {
////			NodoMenu tUiElement = new NodoMenu();
////			tUiElement.setNombre("UI Elements");
////			tUiElement.setIconSclass("z-icon-desktop");
////			tUiElement.setTipoNodoMenuEnum(TipoNodoMenuEnum.CARPETA);
////			hRoot.add(tUiElement);
////			payloadNodoMenu.putInformacion("primeraPagina", false);
////			payloadNodoMenu.putInformacion("ultimaPagina", true);
////		}
////
////		payloadNodoMenu.putInformacion("totalElementosEnTabla", 3);
////		payloadNodoMenu.putInformacion("resultado", "OK");
////		payloadNodoMenu.putInformacion("pagina", pagina);
////		payloadNodoMenu.putInformacion("mensaje", "I:Info:Exito");
////		payloadNodoMenu.putInformacion("numeroElementosRetornados", 1);
////		payloadNodoMenu.putInformacion("totalPaginas", 3);
////		payloadNodoMenu.putInformacion("cantidadRegistrosPagina", 1);
////
////		payloadNodoMenu.setData(hRoot);
////		payloadNodoMenu.putInformacion("resultado", "OK");
////
////		return payloadNodoMenu;
////	}
////
////	public static RPayloadRol getRolesPorOperacionYNodoMenu(Operacion porType, NodoMenu objetoSeleccionado) {
////		List<Rol> roles = new ArrayList<Rol>();
////		
////		Rol rolAdministrador = new Rol();
////		rolAdministrador.setNombre("Administrador");
////		
////		Rol rolRRHH = new Rol();
////		rolRRHH.setNombre("R.R.H.H");
////		
////		roles.add(rolRRHH);
////		roles.add(rolAdministrador);
////		
////		RPayloadRol payloadRol = new RPayloadRol();
////		payloadRol.setData(roles);
////		payloadRol.putInformacion("resultado", "OK");
////		
////		return payloadRol;
////	}
////
////	public static RPayloadOperacion getOperacionesByNodoMenu(NodoMenu objetoSeleccionado) {
////		RPayloadOperacion payloadOperacion = new RPayloadOperacion();
////		
////		List<Operacion> operaciones = new ArrayList<Operacion>();
////
////		Operacion operacionEliminar = OperacionGridHelper.getPorType(OperacionGridEnum.ELIMINAR);
////		List<Rol> rolesEliminar = new ArrayList<Rol>();
////		Rol rolEliminar = new Rol(1);
////		rolEliminar.setNombre("Admin");
////		rolesEliminar.add(rolEliminar);
////		operacionEliminar.setRoles(rolesEliminar);
////		operaciones.add(operacionEliminar);
////		
////		Operacion operacionIncluir = OperacionGridHelper.getPorType(OperacionGridEnum.INCLUIR);
////		List<Rol> rolesIncluir = new ArrayList<Rol>();
////		Rol rolIncluir = new Rol(1);
////		rolIncluir.setNombre("Admin Incl");
////		rolesIncluir.add(rolIncluir);
////		operacionIncluir.setRoles(rolesIncluir);
////		operaciones.add(operacionIncluir);
////		
////		operaciones.add(OperacionGridHelper.getPorType(OperacionGridEnum.MODIFICAR));
////		operaciones.add(OperacionGridHelper.getPorType(OperacionGridEnum.CONSULTAR));
////		operaciones.add(OperacionGridHelper.getPorType(OperacionGridEnum.CUSTOM));
////		
////		Collections.sort(operaciones);
////
////		payloadOperacion.setData(operaciones);
////		payloadOperacion.putInformacion("resultado", "OK");
////		
////		return payloadOperacion;
////	}
////	
////	public static RPayloadOperacion getAllOperaciones() {
////		RPayloadOperacion payloadOperacion = new RPayloadOperacion();
////		
////		List<Operacion> operaciones = new ArrayList<Operacion>();
////
////		Operacion operacionEliminar = OperacionGridHelper.getPorType(OperacionGridEnum.ELIMINAR);
////		operaciones.add(operacionEliminar);
////		
////		Operacion operacionIncluir = OperacionGridHelper.getPorType(OperacionGridEnum.INCLUIR);
////		operaciones.add(operacionIncluir);
////		
////		operaciones.add(OperacionGridHelper.getPorType(OperacionGridEnum.MODIFICAR));
////		operaciones.add(OperacionGridHelper.getPorType(OperacionGridEnum.CONSULTAR));
////		operaciones.add(OperacionGridHelper.getPorType(OperacionGridEnum.CUSTOM));
////		
////		Collections.sort(operaciones);
////
////		payloadOperacion.setData(operaciones);
////		payloadOperacion.putInformacion("resultado", "OK");
////		
////		return payloadOperacion;
////	}

}
