//package vzan.demo.bean;
//
//import org.springframework.context.annotation.Bean;
//
//public class DataBaseConfiguration {
//    @Bean
//    public Jdbc jdbc(DataSource ds, List<JdbiPlugins> jdbiPlugins, List<RowMappers<?>> rowMappers) {
//        TransactionAwareDataSourceProxy dataSourceProxy = new TranscationAwareDataSourceProxy(ds);
//        Jdbi jdbi = Jdbi.create(dataSourceProxy);
//        jdbiPlugins.forEach(jdbi::installPlugin);
//        rowMappers.forEach(jdbi::registerRowMappers0);
//        return jdbi;
//
//    }
//
//    @Bean
//    public JdbiPlugin sqlObjectPlugin(){
//        return new  SqlObjectPlugin();
//    }
//}