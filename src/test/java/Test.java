import com.zbw.gitpic.exception.TipException;
import com.zbw.gitpic.utils.ThreadPool;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RemoteRefUpdate;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author zbw
 * @create 2018/2/27 19:53
 */
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static final void main(String[] args) throws IOException, GitAPIException {
        Repository repository = new FileRepositoryBuilder()
                .setGitDir(new File("F:\\web\\GitPic-Source\\.git"))
                .build();
        Git git = new Git(repository);
        try {
            CredentialsProvider cp = new UsernamePasswordCredentialsProvider("920049380@qq.com", "Zbw19950707");
            Iterable<PushResult> results = git.push().setCredentialsProvider(cp).call();
            PushResult result = results.iterator().next();
            String msg = "未知原因";
            if (null == result) {
                throw new TipException(("push失败: " + msg));
            }
            RemoteRefUpdate.Status status = result.getRemoteUpdate(com.zbw.gitpic.utils.Constants.GIT_MASTER_HEAD).getStatus();
            logger.info(status.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

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
