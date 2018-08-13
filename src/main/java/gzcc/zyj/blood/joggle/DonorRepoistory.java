package gzcc.zyj.blood.joggle;


import gzcc.zyj.blood.demain.Donor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 2017/5/19.
 */
@Repository
public interface DonorRepoistory extends JpaRepository<Donor,String> {
    Donor findByDname(String dname);
    Donor findByDxingming(String dxingming);
    Donor findByDidcard(String didcard);
    List<Donor> findByPlacetime_id(String placetime_id);
}
