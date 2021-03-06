package ru.smartel.strike.specification.event;

import org.springframework.data.jpa.domain.Specification;
import ru.smartel.strike.entity.Event;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Events with specified content part
 */
public class WithContentEvent implements Specification<Event> {
    private String desiredContent;

    public WithContentEvent(String desiredContent) {
        this.desiredContent = "%" + desiredContent.toLowerCase() + "%";
    }

    @Override
    public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.or(
                cb.like(cb.lower(root.get("post").get("titleRu")), desiredContent),
                cb.like(cb.lower(root.get("post").get("titleEn")), desiredContent),
                cb.like(cb.lower(root.get("post").get("titleEs")), desiredContent),
                cb.like(cb.lower(root.get("post").get("titleDe")), desiredContent),
                cb.like(cb.lower(root.get("post").get("contentRu")), desiredContent),
                cb.like(cb.lower(root.get("post").get("contentEn")), desiredContent),
                cb.like(cb.lower(root.get("post").get("contentEs")), desiredContent),
                cb.like(cb.lower(root.get("post").get("contentDe")), desiredContent)
        );
    }
}
