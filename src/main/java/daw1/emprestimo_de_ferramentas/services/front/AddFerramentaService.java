package daw1.emprestimo_de_ferramentas.services.front;

import java.net.http.HttpRequest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import daw1.emprestimo_de_ferramentas.entities.FerramentaEntity;

@Service
public class AddFerramentaService {
    public FerramentaEntity execute(FerramentaEntity ferramenta) {
        RestTemplate rt = new RestTemplate();
        HttpEntity<Object> httpEntity = new HttpEntity<>(ferramenta);
        
        ParameterizedTypeReference<FerramentaEntity> responseType = new ParameterizedTypeReference<FerramentaEntity>() {};
        
        var result = rt.exchange(
            "http://localhost:8080/api/ferramentas/new",
            HttpMethod.POST,
            httpEntity,
            responseType
        );
        
        return result.getBody();
    }
}
