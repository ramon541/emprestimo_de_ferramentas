package daw1.emprestimo_de_ferramentas.services.front;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import daw1.emprestimo_de_ferramentas.entities.FerramentaEntity;

@Service
public class GetFerramentaService {
    
    public FerramentaEntity  execute(Integer id) {
        RestTemplate rt = new RestTemplate();
        HttpEntity<Object> httpEntity = new HttpEntity<>(null);
        
        ParameterizedTypeReference<FerramentaEntity> responseType = new ParameterizedTypeReference<FerramentaEntity>() {};

        var result = rt.exchange(
            "http://localhost:8080/api/ferramentas/get/" + id,
            HttpMethod.GET,
            httpEntity,
            responseType
        );
        
        return result.getBody();
    }
}
