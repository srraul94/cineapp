package net.srraul94.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.srraul94.app.model.Perfil;
import net.srraul94.app.model.Usuario;
import net.srraul94.app.service.IPerfilesService;
import net.srraul94.app.service.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private IUsuariosService serviceUsuarios;
	
	@Autowired
	private IPerfilesService servicePerfiles;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@GetMapping("/index")
	public String index() {
		return "usuarios/listUsuarios";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Usuario usuario) {
		return "usuarios/formUsuario";
	}
	
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Usuario usuario, @RequestParam("perfil") String perfil) {
		System.out.println(usuario);
		System.out.println(perfil);
		
		String tmpPass = usuario.getPwd();
		String encPass = encoder.encode(tmpPass);
		usuario.setPwd(encPass);
		usuario.setActivo(1);
		serviceUsuarios.guardar(usuario);
		
		Perfil perfilTmp = new Perfil();
		perfilTmp.setCuenta(usuario.getCuenta());
		perfilTmp.setPerfil(perfil);
		servicePerfiles.guardar(perfilTmp);
		
		return "redirect:/usuarios/index";	
	}
	
	@GetMapping("/demo-bcrypt") 
	public String pruebaBcrypt() {
		String password = "mari123";
		String encriptado = encoder.encode(password);
		System.out.println("Password encriptado: " + encriptado); 
		return "usuarios/demo";
	}
}
