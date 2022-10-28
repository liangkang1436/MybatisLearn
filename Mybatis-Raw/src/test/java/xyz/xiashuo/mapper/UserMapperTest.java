package xyz.xiashuo.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest {

    SqlSession sqlSession = null;

    /**
     * 方便多个测试方法，直接将获取 SqlSession 的内容提取出来
     */
    @BeforeEach
    public void getSqlSession() throws IOException {
        //1. 读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2. 创建SqlSessionFactoryBuilder对象，通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //3. 创建SqlSession对象，
        // openSession方法参数为空时，通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        // openSession方法参数为true时，通过SqlSession对象所操作的sql都会自动提交
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void testInsertUser() throws IOException {
        if (sqlSession == null) {
            return;
        }
        //4. 通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.insertUser();
        //sqlSession.commit()
        System.out.println("结果：" + result);

    }
    @Test
    public void testUpdateUser() throws IOException {
        if (sqlSession == null) {
            return;
        }
        //4. 通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.updateUser();
        //sqlSession.commit()
        System.out.println("结果：" + result);

    }
    @Test
    public void testDeleteUser() throws IOException {
        if (sqlSession == null) {
            return;
        }
        //4. 通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.deleteUser();
        //sqlSession.commit()
        System.out.println("结果：" + result);

    }
}