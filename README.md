# spring-beanlifecycle
Spring Bean Life Cycle - @PostConstruct ,@PreDestroy


1. Container is created
2. Bean instantiated
3. Dependencies injected
4. custom init() method (@PostConstruct is used to create db connections as soon as container is created)
5. custom utility method
6. custom destroy() method (@PreDestroy is used to close db connections before the container is destroyed)
