package nextstep.subway.line.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.subway.line.domain.Section;
import nextstep.subway.line.domain.Sections;

public class SectionResponse {

    private Long id;
    private Long lineId;
    private Long upStationId;
    private Long downStationId;
    private int distance;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public SectionResponse() {
    }

    public SectionResponse(Long id, Long lineId, Long upStationId, Long downStationId, int distance, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.lineId = lineId;
        this.upStationId = upStationId;
        this.downStationId = downStationId;
        this.distance = distance;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public static SectionResponse of(Section section) {
        return new SectionResponse(section.getId(), section.getLine().getId(), section.getUpStation().getId(), section.getDownStation().getId(), section.getDistance().get(), section.getCreatedDate(),
            section.getModifiedDate());
    }

    public Long getId() {
        return id;
    }

    public Long getLineId() {
        return lineId;
    }

    public Long getUpStationId() {
        return upStationId;
    }

    public Long getDownStationId() {
        return downStationId;
    }

    public int getDistance() {
        return distance;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public static List<SectionResponse> toSectionResponses(Sections sections) {
        return sections.getSections()
            .stream()
            .map(SectionResponse::of)
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "SectionResponse{" +
            "id=" + id +
            ", lineId=" + lineId +
            ", upStationId=" + upStationId +
            ", downStationId=" + downStationId +
            ", distance=" + distance +
            ", createdDate=" + createdDate +
            ", modifiedDate=" + modifiedDate +
            '}';
    }
}
