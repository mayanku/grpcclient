import com.mayank.grpc.User;
import com.mayank.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.*;

public class GrpcClient {

    public static void main(String[] args){
        ManagedChannel channel=ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();

        //stubs
        userGrpc.userBlockingStub userStub=userGrpc.newBlockingStub(channel);
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");
        String userName = myObj.nextLine();
        System.out.println("Enter password");
        String userpass = myObj.nextLine();


        User.LoginRequest loginRequest= User.LoginRequest.newBuilder().setUsername(userName).setPassword(userpass).build();
        userStub.login(loginRequest);

        User.APIResponse response=userStub.login(loginRequest);
        System.out.println(response.getResponsemessage());
        //userStub.logout();
    }
}
