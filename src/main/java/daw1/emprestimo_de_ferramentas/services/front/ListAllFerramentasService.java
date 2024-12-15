package daw1.emprestimo_de_ferramentas.services.front;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import daw1.emprestimo_de_ferramentas.entities.FerramentaEntity;

@Service
public class ListAllFerramentasService {
    
    public List<FerramentaEntity> execute() {
        RestTemplate rt = new RestTemplate();
        ParameterizedTypeReference<List<FerramentaEntity>> responseType = new ParameterizedTypeReference<List<FerramentaEntity>>() {
            
        };
        HttpEntity<Object> httpEntity = new HttpEntity<>(null);

        var result = rt.exchange(
            "http://localhost:8080/api/ferramentas/get",
            HttpMethod.GET,
            httpEntity,
            responseType
        );
        
        return result.getBody();
    }
}
