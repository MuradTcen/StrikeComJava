package ru.smartel.strike.model.reference;

import org.springframework.data.annotation.AccessType;
import ru.smartel.strike.model.interfaces.Names;

import javax.persistence.*;

@MappedSuperclass
abstract public class EntityWithNames implements Names {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @AccessType(AccessType.Type.PROPERTY) //чтобы доставать id из прокси (без загрузки объекта из базы)
    int id;
    @Column(name = "name_ru")
    String nameRu;
    @Column(name = "name_en")
    String nameEn;
    @Column(name = "name_es")
    String nameEs;

    public EntityWithNames() {
    }

    public EntityWithNames(String nameRu, String nameEn, String nameEs) {
        this.nameRu = nameRu;
        this.nameEn = nameEn;
        this.nameEs = nameEs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNameRu() {
        return nameRu;
    }

    @Override
    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    @Override
    public String getNameEn() {
        return nameEn;
    }

    @Override
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Override
    public String getNameEs() {
        return nameEs;
    }

    @Override
    public void setNameEs(String nameEs) {
        this.nameEs = nameEs;
    }

    @Override
    public String getNameByLocale(String locale) {
        switch (locale) {
            case "ru":
                return getNameRu();
            case "en":
                return getNameEn();
            case "es":
                return getNameEs();
            default:
                return "";
        }
    }
}
