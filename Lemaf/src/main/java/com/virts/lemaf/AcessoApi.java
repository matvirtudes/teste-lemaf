/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virts.lemaf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author Matheus
 */
public class AcessoApi {

    public String getPalavra(int posicao) throws ClientProtocolException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://testes.ti.lemaf.ufla.br/api/Dicionario/"+ posicao);
        HttpResponse response = client.execute(request);
        
        Integer httpCode = response.getStatusLine().getStatusCode();
        
        if(httpCode != HttpStatus.SC_OK)
            throw new IOException("Erro no servidor");
                    
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));

        return rd.readLine().replaceAll("\"", "");
    }

}
