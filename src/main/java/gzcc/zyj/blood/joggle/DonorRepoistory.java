package gzcc.zyj.blood.joggle;


import gzcc.zyj.blood.demain.Donor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 2017/5/19.
 */
@Repository
public interface DonorRepoistory extends JpaRepository<Donor,String> {
    Donor findByDname(String dname);
    Donor findByDidcard(String didcard);
}
