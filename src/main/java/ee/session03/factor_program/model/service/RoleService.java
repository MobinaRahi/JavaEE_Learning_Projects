package ee.session03.factor_program.model.service;

import ee.session03.factor_program.model.entity.Role;
import ee.session03.factor_program.model.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

public class RoleService {
    public void saveRole(Role role) {
        RoleRepository roleRepository = new RoleRepository();
        roleRepository.save(role);
    }

    public void updateRole(Role role) {
        RoleRepository roleRepository = new RoleRepository();
        roleRepository.update(role);
    }

    public void deleteRole(Integer id) {
        RoleRepository roleRepository = new RoleRepository();
        roleRepository.deleteById(id);
    }

    public Optional getRole(Integer id) {
        RoleRepository roleRepository = new RoleRepository();
        return roleRepository.findById(id);
    }

    public List<Role> getAllRole() {
        RoleRepository roleRepository = new RoleRepository();
        return roleRepository.findAll();
    }
}
