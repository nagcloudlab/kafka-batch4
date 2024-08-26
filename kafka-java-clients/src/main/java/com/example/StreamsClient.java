package com.example;

import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


// stream
// source topic(s)  -> 6 partitions
// 6 tasks
// 1 thread -> 6 tasks
// 2 threads -> 3 tasks each
// 3 threads -> 2 tasks each


// why we need streams api?

// - less code
// - real time processing
// - vertical / horizontal scaling
// - exactly once processing

public class StreamsClient {
    public static void main(String[] args) {

        Properties streamsProps = new Properties();
        streamsProps.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        streamsProps.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-client");
        streamsProps.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, "org.apache.kafka.common.serialization.Serdes$StringSerde");
        streamsProps.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, "org.apache.kafka.common.serialization.Serdes$StringSerde");
        streamsProps.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, 3); // veritical / horizontal scaling

        // exactly once processing
        streamsProps.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE);
        streamsProps.put(StreamsConfig.EXACTLY_ONCE_V2, "true");


        // Topology made with processor(s)
        // - source processor
        // - intermediate processor ( filter, map, flatMap, etc)
        // - sink processor

        StreamsBuilder builder = new StreamsBuilder();

        //-------------------------------------------
        // stateless stream processing
        //-------------------------------------------

//        KStream<String, String> ks0 = builder.stream("numbers"); // source processor
//        KStream<String, String> ks1 = ks0.filter((k, v) -> Integer.parseInt(v) % 2 == 0); // intermediate processor
//        ks1.to("even-numbers"); // sink processor

//        KStream<String, String> stream = builder.stream("numbers");

        // #1.filter
//        stream.filter((k, v) -> Integer.parseInt(v) % 2 == 0)
//                .peek((k, v) -> System.out.println("even: " + v))
//                .to("even-numbers");

//        stream.filter((k, v) ->Integer.parseInt(v) % 2 != 0)
//                .peek((k, v) -> System.out.println("odd: " + v))
//                .to("odd-numbers");

        // 2. map

//        stream.mapValues(v -> String.valueOf(Integer.parseInt(v) * 2))
//                .peek((k, v) -> System.out.println("double: " + v))
//                .to("doubled-numbers");

        // 3. flatMap

        // process every number as number, number * 2, number * 3
//        stream.flatMapValues(v -> {
//            return List.of(String.valueOf(Integer.parseInt(v) * 1),
//                    String.valueOf(Integer.parseInt(v) * 2),
//                    String.valueOf(Integer.parseInt(v) * 3));
//                })
//                .peek((k, v) -> System.out.println("flat-mapped: " + v))
//                .to("flat-mapped-numbers");

        // 4. branch

//        KStream<String, String>[] branches = stream.branch(
//                (k, v) -> Integer.parseInt(v) % 2 == 0,
//                (k, v) -> Integer.parseInt(v) % 2 != 0
//        );
//
//        KStream<String,String> ks1=branches[0]
//                .map((k, v) -> KeyValue.pair(k, String.valueOf(Integer.parseInt(v) * 20)));
//
//        KStream<String,String> ks2=branches[1]
//                .map((k, v) -> KeyValue.pair(k, String.valueOf(Integer.parseInt(v) * 10)));
//
//        // merge
//        ks1.merge(ks2)
//                .peek((k, v) -> System.out.println("merged: " + v))
//                .to("merged-numbers");


        //-------------------------------------------
        // stateful stream processing
        //-------------------------------------------

        // so far how many even/odd numbers processed ( e.g stateful processing)

        KStream<String, String> ks = builder.stream("numbers");
        KStream<String, String> ks1 = ks.selectKey((k, v) -> Integer.parseInt(v) % 2 == 0 ? "even" : "odd");
        KTable table = ks1.groupByKey().count(); // state-store
        // every 10 seconds or buffer size 1000
        table.toStream().peek((k, v) -> System.out.println(k + " " + v)).to("counted-numbers");


        Topology topology = builder.build();

        KafkaStreams streams = new KafkaStreams(topology, streamsProps);
        streams.start();

        // shutdown hook to correctly close the streams application
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    }
}
