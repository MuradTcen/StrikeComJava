package ru.smartel.strike.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smartel.strike.dto.response.event.EventDetailDTO;
import ru.smartel.strike.exception.BusinessRuleValidationException;

@Service
@Transactional(rollbackFor = Exception.class)
public interface EventService {

    @PreAuthorize("permitAll()")
    EventDetailDTO index(Locale locale, boolean withRelatives);

    @PreAuthorize("permitAll()")
    EventDetailDTO getAndIncrementViews(Integer eventId, Locale locale, boolean withRelatives);

    @PreAuthorize("isFullyAuthenticated()")
    void setFavourite(Integer eventId, Integer userId, boolean isFavourite);

    @PreAuthorize("isFullyAuthenticated()")
    EventDetailDTO create(JsonNode data, Integer userId, Locale locale) throws BusinessRuleValidationException;

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR') or isEventAuthor(#eventId)")
    EventDetailDTO update(Integer eventId, JsonNode data, Integer userId, Locale locale) throws BusinessRuleValidationException;

    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    void delete(Integer eventId);
}
