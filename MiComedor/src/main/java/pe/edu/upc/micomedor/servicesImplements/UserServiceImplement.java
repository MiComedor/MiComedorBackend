package pe.edu.upc.micomedor.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micomedor.entities.Users;
import pe.edu.upc.micomedor.repositories.IUserRepository;
import pe.edu.upc.micomedor.servicesInterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository usR;

    @Override
    public void insert(Users usr) {
        usR.save(usr);
    }

    @Override
    public void delete(int id) {
        usR.deleteById(id);
    }

    @Override
    public List<Users> list() {
        return usR.findAll();
    }

    @Override
    public int findLastUserRegister() {
        return usR.findLastUserRegister();
    }

    @Override
    public int findByNameRole(String name_role) {
        return usR.findByNameRole(name_role);
    }

    @Override
    public int findByNameCountry(String name_country) {
        return usR.findByNameCountry(name_country);
    }

    @Override
    public Users listId(Integer idUsuario){
        return usR.findById(idUsuario).orElse(new Users());
    }
}
