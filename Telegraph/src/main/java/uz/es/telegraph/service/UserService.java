package uz.es.telegraph.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.es.telegraph.dto.UserCreatedDto;
import uz.es.telegraph.entity.UserEntity;
import uz.es.telegraph.exceptons.UniqueException;
import uz.es.telegraph.exceptons.UserCheckException;
import uz.es.telegraph.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserEntity add(UserCreatedDto userCreatedDto) {
        UserEntity userEntity = modelMapper.map(userCreatedDto, UserEntity.class);
        if (userRepository.existsByPhoneNumber(userEntity.getPhoneNumber())){
            throw new UniqueException("This phoneNumber already exists");
        }
       return userRepository.save(userEntity);
    }

    public UserEntity signIn(String phoneNumber, String password) {

        UserEntity userEntity = userRepository.findUserEntitiesByPhoneNumber(phoneNumber)
                .orElseThrow(
                        () -> new UserCheckException("Phone number not found")
                );
        if (userEntity.getPassword().equals(password)) {
            return userEntity;
        }
        throw new UserCheckException("password not found");
    }


}
