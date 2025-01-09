package org.example.BackEnd;
import com.openai.models.ChatCompletion;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatCompletionMessageParam;
import com.openai.models.ChatCompletionUserMessageParam;
import com.openai.models.ChatModel;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import java.util.List;

public class APIClient {

     String apiKey = System.getenv("apiKey");

    OpenAIClient client = OpenAIOkHttpClient.builder()
            .apiKey(apiKey)
            .build();
 public ChatCompletion AIResponse(){
     ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
             .messages(List.of(ChatCompletionMessageParam.ofChatCompletionUserMessageParam(ChatCompletionUserMessageParam.builder()
                     .role(ChatCompletionUserMessageParam.Role.USER)
                     .content(ChatCompletionUserMessageParam.Content.ofTextContent("Tell me a joke"))
                     .build())))
             .model(ChatModel.GPT_4O_MINI)
             .build();
     ChatCompletion chatCompletion = client.chat().completions().create(params).validate();
     System.out.println(chatCompletion.toString());
     return chatCompletion;
 }

}
