# paypay-exercise

## Part 1

Please run `mvn test` to execute the unit tests.

## Part 2

Design A Google Analytic like Backend System. We need to provide Google Analytic like services to our customers. Pls provide a high level solution design for the backend system. Feel free to choose any open source tools as you want.

The system needs to:

- handle large write volume: Billions write events per day.
- handle large read/query volume: Millions merchants want to get insight about their business. Read/Query patterns are time-series related metrics.
- provide metrics to customers with at most one hour delay.
- run with minimum downtime.
- have the ability to reprocess historical data in case of bugs in the processing logic.

### Solution

Please see attached diagram for reference.

1. The customer app implements required user action event API.
2. User interaction is recorded through event API and handled by capture server.
3. Capture server writes to Cassandra cluster.
4. Cassandra publishes write events to Kafka.
5. Processing server subscribes to Kafka (replay available within limited time window).
6. Processing server crunches data and writes analytics to SQL cluster.
7. SQL server provides rich query support for query server.
8. Customer queries for analytics data through query server.

- Partitioned Cassandra should scale as write events data set size increases to huge size
- Due to performance constraints of capture server I would choose something like Go, or even C. Go has similar performance and small footprint as C, but better modern web support out of the box.
- Processing server should have good CPU and memory - tech choice is more flexible; maybe Java is a good choice. After receiving events from Kafka, processing is done in thread pool or task queue.
- Query server could also be Java based.
- Analytics frontend built using React / Redux.
- Obviously Cassandra cluster should have a backup.

