import com.zbw.gitpic.utils.ThreadPool;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

/**
 * @author zbw
 * @create 2018/2/27 19:53
 */
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static final void main(String[] args) throws IOException, GitAPIException {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            ThreadPool.getInstance().execute(new Thread(() -> {
                logger.info("now time:{}",new Date());
                logger.info("Thread i:{}", finalI);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("now time:{}",new Date());
            }));
        }

        ThreadPool.getInstance().shutdown();

       /* Repository repository = new FileRepositoryBuilder()
                .setGitDir(new File("E:\\workspace\\web\\GitPic-Source\\GitPic-Source\\.git"))
                .build();
        Git git = new Git(repository);
        // CredentialsProvider cp = new UsernamePasswordCredentialsProvider("920049380@qq.com", "Zbw19950707");
        // git.push().setCredentialsProvider(cp).call();
        ObjectId ObjectId = repository.resolve(Constants.HEAD);
        ObjectId.toObjectId().toObjectId();
        System.out.println(ObjectId.toString());*/
    }
}
