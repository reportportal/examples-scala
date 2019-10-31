# examples-scala
A project with scala tests to show how they works with Report Portal.
## Known issues
* Logging into Report Portal does not work for scalatest. Scalatest uses internal 
queue to publish test events, such as "execution start", "test start", "test finish".
Such design causes desync between logging and test events: logging events come
synchronously during test execution and test events come asynchronously after test 
execution. That leads to a situation when a client doesn't know to which test a log
event is related and drop it. 
  * As a possible solution we need to implement a scala log appender, which will
  send logging events to the same queue with test events.
