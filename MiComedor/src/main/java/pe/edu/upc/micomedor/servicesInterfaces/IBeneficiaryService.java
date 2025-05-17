package pe.edu.upc.micomedor.servicesInterfaces;

import pe.edu.upc.micomedor.entities.Beneficiary;


import java.util.List;

public interface IBeneficiaryService {
    public void insert(Beneficiary beneficiary);
    public void delete(int idBeneficiary);
    public Beneficiary listId(int idBeneficiary);
    public List<Beneficiary> list();
    public void update(Beneficiary beneficiary);
    List<Beneficiary> findBeneficiaryByUserId(int idUser);

}
