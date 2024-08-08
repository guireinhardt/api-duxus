package br.com.duxusdesafio.service;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

/**
 * Service que possuirá as regras de negócio para o processamento dos dados
 * solicitados no desafio!
 *
 * @author carlosau
 */
@Service
public class ApiService {

    /**
     * om os nomes dos integrantes do time daquela data
     */
    public Map<String, Object> timeDaData(LocalDate data, List<Time> todosOsTimes) {
        // Criando lista de times
        List<Time> timeDaData = new ArrayList<>();
        //verificar todos os times da lista e iterar para a composição do time
        for (Time time : todosOsTimes) {
            if (time.getData().equals(data)) {
               timeDaData.add(time);
                }
            }
        // iniciando o nome do time vazio e criando uma lista de integrantes de time
        String nomeTime = null;
        List<String> integrantesTime = new ArrayList<>();
        //verificando se tem algum time na data
        if (!timeDaData.isEmpty()) {
            Time ultimoTime = timeDaData.get(timeDaData.size() - 1);
            nomeTime = ultimoTime.getNome();

            for (ComposicaoTime composicaoTime : ultimoTime.getComposicaoTime()) {
                integrantesTime.add(composicaoTime.getIntegrante().getNome());
            }
        }

        Map<String,Object> composicaoTimeFinal = new HashMap<>();
            composicaoTimeFinal.put("nomeTime",nomeTime);
            composicaoTimeFinal.put("integrantesTime",integrantesTime);

        return composicaoTimeFinal;
    }

    /**
     * Vai retornar o integrante que tiver presente na maior quantidade de times
     * dentro do período
     */
    public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        Map<Integrante, Integer> contarIntegrante = new HashMap<>();
        //percorrer todos os times

        for(Time time : todosOsTimes){
            //verificar se a data está dentro do range da data inicial e da data final
            if ((dataInicial.compareTo(time.getData())) <= 0 && dataFinal.compareTo(time.getData()) >=0){
                for (ComposicaoTime comptime : time.getComposicaoTime()){
                    Integrante integrante = comptime.getIntegrante();
                    contarIntegrante.put(integrante, contarIntegrante.getOrDefault(integrante,0) + 1);
                }
            }
        }
         Integrante integranteMaisUsado = null;
         Integer contador = 0;

         for(Map.Entry<Integrante,Integer> entry : contarIntegrante.entrySet()){
             if (entry.getValue() > contador){
                 integranteMaisUsado = entry.getKey();
                 contador = entry.getValue();
             }
         }


        return integranteMaisUsado;
    }

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time mais comum
     * dentro do período
     */
    public List<String> timeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar a função mais comum nos times dentro do período
     */
    public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        return null;
    }


    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o número (quantidade) de Funções dentro do período
     */
    public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

}
