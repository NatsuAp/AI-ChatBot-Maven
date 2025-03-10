package org.example.BackEnd.ChatBackEnd;
import org.example.BackEnd.Embeddings.EmbeddingsRequests;
import org.example.FrontEnd.TextArea.Searchbox;


public class UserInput {
    EmbeddingsRequests requests = new EmbeddingsRequests();
    Searchbox box = new Searchbox();
    public String embedding;
    public String userInput;

    public void calculateEmbedding(){
        
        this.setEmbedding(requests.embeddingsRequest(this.userInput));
    }

    public void setUserInput(String userInput){
        this.userInput = userInput;
    }

    private void setEmbedding(String embedding){
        this.embedding = embedding;
    }
    //  UserInput user = new UserInput();
    //     user.setUserInput(this.Searchbox.getText());
    //     user.calculateEmbedding();
    //     user.embedding
}
