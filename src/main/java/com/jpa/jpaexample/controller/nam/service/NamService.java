package com.jpa.jpaexample.controller.nam.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.jpaexample.domain.CrudEntity;
import com.jpa.jpaexample.repository.CrudEntityRepository;

@Service
public class NamService {

    @Autowired
    private CrudEntityRepository crudEntityRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private CrudEntity crudEntity;

    public List<CrudEntity> searchAll() {
        return crudEntityRepository.findAll();
    }

    public List<CrudEntity> searchParam(int age) {
        return entityManager.createQuery("select m from sample_member m where age > :age", CrudEntity.class)
                            .setParameter("age", age)
                            .getResultList();
    }

    public List<CrudEntity> searchParamRepo(String name) {
        return crudEntityRepository.searchParamRepo(name);
    }
    
    public CrudEntity searchBoardDetail(CrudEntity crudEntity) {
    	System.out.println(crudEntity);
    	return crudEntityRepository.searchBoardDetail(crudEntity.getName());
    }

    public String insertMember(CrudEntity crudEntity) {
        if(crudEntityRepository.findById(crudEntity.getName()).isPresent()) {
            return "동일한 이름이 이미 있습니다";
        } else {
            crudEntityRepository.save(crudEntity);
            return "이름 : " + crudEntity.getName() + " 나이 : " + crudEntity.getAge() + "으로 추가 되었습니다";
        }
    }

    public String updateMember(CrudEntity crudEntity) {
        if(crudEntityRepository.findById(crudEntity.getName()).isEmpty()) { // 값 존재여부 확인
            return "입력한 " + crudEntity.getName() + "이 존재하지 않습니다";
        } else {
        	crudEntityRepository.save(crudEntity);
            return crudEntity.getName() + "의 나이를 " + crudEntity.getAge()+ "로 변경 완료";
        }
    }

    public String deleteMember(String name) {
        if(crudEntityRepository.findById(name).isEmpty()) { // 값 존재여부 확인
            return "입력한 " + name + "이 존재하지 않습니다";
        } else {
            crudEntityRepository.delete(CrudEntity.builder().name(name).build());
            return name + " 삭제 완료";
        }
    }

}
