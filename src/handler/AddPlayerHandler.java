package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import dao.PlayerDao;
import model.Player;
import request.AddPlayerRequest;
import response.AddPlayerResponse;

public class AddPlayerHandler {

    private PlayerDao playerDao = new PlayerDao();



    public AddPlayerResponse addPlayer(AddPlayerRequest request, Context context) throws Exception {
        LambdaLogger logger = context.getLogger();
        logger.log("Entering addPlayer");
        AddPlayerResponse response;


        try {
            response = playerDao.addPlayer(request.getPlayerName(), request.getGameId());
        }
        catch (Exception ex) {
            throw new Exception("Internal Server Error");
        }

        return response;
    }

}
