package com.dotorder.DotOrder.service;

import com.dotorder.DotOrder.domain.Store;
import com.dotorder.DotOrder.domain.Users;
import com.dotorder.DotOrder.dto.StoreDto;
import com.dotorder.DotOrder.dto.UsersDto;
import com.dotorder.DotOrder.repository.UsersRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@NoArgsConstructor
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public int saveUsers(UsersDto usersDto){
        Users users = usersDto.toEntity();
        usersRepository.save(users);
        return users.getIdx();
    }

    @Transactional
    public Users findById(int idx){
        Users entity = usersRepository.findById(idx).orElseThrow(()-> new IllegalArgumentException("해당 유저가 없습니다. id="+idx));
        return entity;
    }

}
