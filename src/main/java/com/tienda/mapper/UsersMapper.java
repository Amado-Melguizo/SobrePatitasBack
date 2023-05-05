package com.tienda.mapper;

import com.tienda.dtos.UsersDTO;
import com.tienda.entities.Users;

/*el mapper mapea objetos de un cliente a otro ej : 
* una entidad se convierte en DTO y viceversa.
*/

// lombok y mapStruct dependencia.

public class UsersMapper {
	public static UsersDTO mapToDTO(Users usuariosEntity) {
		UsersDTO usuariosdto = new UsersDTO();
		usuariosdto.setId(usuariosEntity.getId());
		usuariosdto.setEmail(usuariosEntity.getEmail());
		usuariosdto.setPass(usuariosEntity.getPass());
		usuariosdto.setUser_img(usuariosEntity.getUser_img());
		usuariosdto.setUsername(usuariosEntity.getUsername());
		return usuariosdto;
	} 

	public static Users mapToEntity(UsersDTO usuariosdto) {
		Users usuariosEntity = new Users();
		usuariosEntity.setId(usuariosdto.getId());
		usuariosEntity.setEmail(usuariosdto.getEmail());
		usuariosEntity.setPass(usuariosdto.getPass());
		usuariosEntity.setUser_img(usuariosdto.getUser_img());
		usuariosEntity.setUsername(usuariosdto.getUsername());
		return usuariosEntity;
	}
}
