package at.tugraz.kmi.medokyservice.resources;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.tugraz.kmi.medokyservice.bl.CoreLogic;
import at.tugraz.kmi.medokyservice.recommendations.RecommendationClassification;
import at.tugraz.kmi.medokyservice.recommendations.Recommendations;


@Path("/")
public class TriggerMedoky{
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("trigger/userId/{userId}/courseId/{courseId}/number/{number}/environment/{environment}")
	public RecommendationId trigger(@DefaultValue("1") @PathParam("userId") String userId, @DefaultValue("1") @PathParam("courseId") String courseId, @DefaultValue("3") @PathParam("number") String number,@DefaultValue("textBased") @PathParam("environment") String environment, @DefaultValue("application/json") @HeaderParam("Accept") String accept) {
		//RecommendationId id = new RecommendationId("test");
		//return id;
		int intNumber = Integer.valueOf(number);
		return CoreLogic.getInstance().triggerUserClassification(userId, courseId, intNumber, environment);
	}
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("triggerRecommendation/userId/{userId}/courseId/{courseId}/environment/{environment}/type/{type}")
	public RecommendationId triggerRecommendation(@DefaultValue("1") @PathParam("userId") String userId, @DefaultValue("1") @PathParam("courseId") String courseId, @DefaultValue("textBased") @PathParam("environment") String environment, @DefaultValue("LearningResource") @PathParam("type") String type, @DefaultValue("application/json") @HeaderParam("Accept") String accept) {
		//RecommendationId id = new RecommendationId("test");
		return CoreLogic.getInstance().triggerUserClassification(userId, courseId, environment, type);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getRecommendation/recommendationId/{recommendationId}")
	public Recommendations getRecommendation(@DefaultValue("-1") @PathParam("recommendationId") String recommendationId, @DefaultValue("application/json") @HeaderParam("Accept") String accept) {
		return CoreLogic.getInstance().getRecommendation(recommendationId);
	}

		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("triggerRecommendationCycle/sourceId/{sourceId}/userId/{userId}/courseId/{courseId}")
	 public Info triggerRecommendationCycle(@DefaultValue("ARLearn") @PathParam("sourceId") String sourceId, @DefaultValue("1") @PathParam("userId") String userId, @DefaultValue("1") @PathParam("courseId") String courseId, @DefaultValue("application/json") @HeaderParam("Accept") String accept) {
		return CoreLogic.getInstance().triggerRecommendationCycle(sourceId, userId, courseId);
	 }

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getTagRecommendations/userId/{userId}/courseId/{courseId}")
	public TagRecommendations getTagRecommendations(@DefaultValue("1") @PathParam("userId") String userId, @DefaultValue("1") @PathParam("courseId") String courseId, @DefaultValue("application/json") @HeaderParam("Accept") String accept) {
		return CoreLogic.getInstance().getTagRecommendations(userId, courseId);
		//"tag1, tag2, tag3, tag4, tag5";
		//return CoreLogic.getInstance().getTagRecommendations(userId, courseId);
	 }
}
