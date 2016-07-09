package karen.core.util.payload;

import lights.core.payload.response.IPayloadResponse;

public class UtilPayload {

	public static boolean isOK(IPayloadResponse<?> iPayloadResponse) {
		if (iPayloadResponse == null) {
			return false;
		}
		return (Boolean) iPayloadResponse.getInformacion(IPayloadResponse.IS_OK);
	}
}
