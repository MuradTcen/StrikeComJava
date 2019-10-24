package ru.smartel.strike.dto.response.event;

import java.util.List;

public class EventListWrapperDTO {
    private List<EventListDTO> data;
    private Meta meta;

    public EventListWrapperDTO(List<EventListDTO> data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public List<EventListDTO> getData() {
        return data;
    }

    public void setData(List<EventListDTO> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public static class Meta {
        private Long total;
        private Integer currentPage;
        private Integer perPage;
        private Long lastPage;

        public Meta(Long total, Integer currentPage, Integer perPage, Long lastPage) {
            this.total = total;
            this.currentPage = currentPage;
            this.perPage = perPage;
            this.lastPage = lastPage;
        }

        public Long getTotal() {
            return total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }

        public Integer getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        public Integer getPerPage() {
            return perPage;
        }

        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }

        public Long getLastPage() {
            return lastPage;
        }

        public void setLastPage(Long lastPage) {
            this.lastPage = lastPage;
        }
    }
}