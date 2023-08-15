package ecobridge.EcologyMap.domain;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreatureLocation {

    //고유 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long locationId;

    //위도
    @Column(name="creature_latitude")
    private double creatureLatitude;

    //경도
    @Column(name="creature_longitude")
    private double creatureLongitude;

    //생물 ID
    @ManyToOne //CreationLocation 엔티티가 하나의 Creature 엔티티와 관계를 맺을 수 있음을 타나냄.
    @JoinColumn(name = "creature_id")
    private Creature creature;

    //장소 이름
    @Column(name="location_name", nullable = true)
    private String locationName;

//    @Builder //빌더 패턴으로 객체 생성
//    public Creature_location(double creature_latitude, double creature_longitude) {
//        this.creature_latitude = creature_latitude;
//        this.creature_longitude = creature_longitude;
//    }

}

