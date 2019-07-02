package com.himadri.school.questionnaire.domain.converter;


/**
 *  This is my initial idea to convert the entity to dto, as of now I am using modelmapper so
 *  Will see if we need this class.
 * @param <G>
 * @param <V>
 */
public abstract class AbstractConverter<G,V>{

    public G convertToEntity(V v){
        //todo
        return null;
    }

    public V convertToDTO(G g){
        //todo
        return null;
    }

}
