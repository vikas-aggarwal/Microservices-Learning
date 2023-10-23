package com.example.todo.todo_service.repo;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.Result;
import org.apache.tinkerpop.gremlin.driver.ResultSet;
import org.apache.tinkerpop.gremlin.driver.ser.GraphSONMessageSerializerV1d0;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TodoRepo {
    private Cluster cluster;
    private Client client;

    public TodoRepo(@Value("${database.host}") String host, @Value("${database.port}") Integer port) {
        this.cluster = Cluster.build().addContactPoint(host)//.credentials(userName, password)
                .enableSsl(false).port(port).serializer(new GraphSONMessageSerializerV1d0())
                //.minConnectionPoolSize(connectionPoolMinSize)
                .create();

        this.client = cluster.connect();
    }

    public String getTodos() throws InterruptedException, ExecutionException {
        ResultSet resultSet = this.client.submit("g.V().hasLabel(\"Todo\")");
        List<org.apache.tinkerpop.gremlin.driver.Result> results = resultSet.all().get();
        
        String data = "";
        for(Result res: results) {
            data +=res.toString();
        }

        return data;
    }
}
