package org.example.BackEnd.ChatBackEnd;

import org.example.BackEnd.Embeddings.EmbeddingsRequests;
import org.example.FrontEnd.TextArea.Searchbox;

public class UserInput {
    EmbeddingsRequests requests = new EmbeddingsRequests();
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
}
