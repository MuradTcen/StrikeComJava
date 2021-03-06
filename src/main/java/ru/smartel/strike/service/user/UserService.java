package ru.smartel.strike.service.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smartel.strike.dto.request.user.UserUpdateRequestDTO;
import ru.smartel.strike.dto.response.user.UserDetailDTO;
import ru.smartel.strike.entity.User;
import ru.smartel.strike.repository.etc.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    private final UserRepository userRepository;
    private final UserDTOValidator validator;

    public UserService(UserRepository userRepository, UserDTOValidator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    public UserDetailDTO get(long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("Пользователь не найден")
        );

        return UserDetailDTO.from(user);
    }

    public Optional<User> get(String uid) {
        return userRepository.findFirstByUid(uid);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR') or principal.getId() == #dto.userId and null == #dto.roles")
    public UserDetailDTO updateOrCreate(UserUpdateRequestDTO dto) {
        validator.validateUpdateDTO(dto);

        User user = userRepository.findById(dto.getUserId()).orElseThrow(
                () -> new EntityNotFoundException("Пользователь не найден")
        );

        Optional.ofNullable(dto.getFcm()).ifPresent(user::setFcm);
        Optional.ofNullable(dto.getRoles()).ifPresent(user::setRoles);

        return UserDetailDTO.from(user);
    }

    public void updateOrCreate(String uid, String name, String email, String imageUrl) {
        User user = userRepository.findFirstByUid(uid).orElse(null);
        if (isNull(user)) {
            user = new User();
            user.setUid(uid);
        }
        user.setName(name);
        user.setEmail(email);
        user.setImageUrl(imageUrl);
        userRepository.save(user);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR') or principal.getId() == #userId")
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}
