package ru.smartel.strike.specification.conflict;

import org.springframework.data.jpa.domain.Specification;
import ru.smartel.strike.entity.Conflict;
import ru.smartel.strike.entity.Event;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Conflicts which have specified text in title or which have events containing this text in contents/titles
 */
public class TextMentionConflict implements Specification<Conflict> {
    private String desiredContent;

    public TextMentionConflict(String desiredContent) {
        this.desiredContent = "%" + desiredContent.toLowerCase() + "%";
    }

    @Override
    public Predicate toPredicate(Root<Conflict> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (desiredContent.equals("%%")) return null;
        Join<Conflict, Event> join = root.join("events", JoinType.LEFT);
        return cb.or(
                cb.like(cb.lower(root.get("titleRu")), desiredContent),
                cb.like(cb.lower(root.get("titleEn")), desiredContent),
                cb.like(cb.lower(root.get("titleEs")), desiredContent),
                cb.like(cb.lower(root.get("titleDe")), desiredContent),
                cb.like(cb.lower(join.get("post").get("titleRu")), desiredContent),
                cb.like(cb.lower(join.get("post").get("titleEn")), desiredContent),
                cb.like(cb.lower(join.get("post").get("titleEs")), desiredContent),
                cb.like(cb.lower(join.get("post").get("titleDe")), desiredContent),
                cb.like(cb.lower(join.get("post").get("contentRu")), desiredContent),
                cb.like(cb.lower(join.get("post").get("contentEn")), desiredContent),
                cb.like(cb.lower(join.get("post").get("contentEs")), desiredContent),
                cb.like(cb.lower(join.get("post").get("contentDe")), desiredContent)
        );
    }
}
