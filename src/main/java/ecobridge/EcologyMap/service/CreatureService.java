package ecobridge.EcologyMap.service;

import ecobridge.EcologyMap.domain.Creature;
import ecobridge.EcologyMap.domain.Creature_location;
import ecobridge.EcologyMap.dto.CreatureDTO;
import ecobridge.EcologyMap.repository.CreatureLocationRepository;
import ecobridge.EcologyMap.repository.CreatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service //빈으로 등록
public class CreatureService {

    private final CreatureRepository creatureRepository;
    private final CreatureLocationRepository creatureLocationRepository;

    @Autowired
    public CreatureService(CreatureRepository creatureRepository, CreatureLocationRepository creatureLocationRepository) {
        this.creatureRepository = creatureRepository;
        this.creatureLocationRepository = creatureLocationRepository;
    }


    /*
     * 전체 list 마커 찍기 -  DB 에서 생물의 위치 정보를 가져와 'CreatureDTO' 객체들을 생성하여 반환하는 메서드
     */
    public List<CreatureDTO> getAllCreatureLocations() {
        //findAll() 호출 -> DB 에서 모든 'Creature_location' 엔티티를 가져오기
        List<Creature_location> locations = creatureLocationRepository.findAll();
        List<CreatureDTO> creatureDTOs = new ArrayList<>();

        //가져온 위치 정보들을 순회하면서
        for (Creature_location location : locations) {
            Creature creature = location.getCreature(); //생물 정보를 바로 가져옵니다

            //해당 위치에 연관된 생물 정보가 있다면
            if (creature != null) {
                CreatureDTO dto = new CreatureDTO();  //'CreatureDTO' 객체 생성
                dto.setCreature_latitude(location.getCreature_latitude()); //위도 정보 설정
                dto.setCreature_longitude(location.getCreature_longitude()); //경도 정보 설정
                creatureDTOs.add(dto); //위치 정보 설정 후 'creatureDTOs' 리스트에 추가.
            }
        }

        //모든 위치 정보에 대해 반복 수행 후, 생성된 'creatureDTOs' 리스트 반환.
        return creatureDTOs;
    }

}
