package daw1.emprestimo_de_ferramentas.services.front;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import daw1.emprestimo_de_ferramentas.entities.UsuarioEntity;

@Service
public class GetUsuarioService {
    
    public UsuarioEntity execute(Integer id) {
        RestTemplate rt = new RestTemplate();
        HttpEntity<Object> httpEntity = new HttpEntity<>(null);
        
        ParameterizedTypeReference<UsuarioEntity> responseType = new ParameterizedTypeReference<UsuarioEntity>() {};

        var result = rt.exchange(
            "http://localhost:8080/api/usuarios/get/" + id,
            HttpMethod.GET,
            httpEntity,
            responseType
        );
        
        return result.getBody();
    }
}
