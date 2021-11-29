package Enum;

public enum VehicleType implements VehicleSeatCount{
	Activa{
		@Override
		public int getAvailableSeatCount() {
			return 1;
		}
	},
	Polo{
		@Override
		public int getAvailableSeatCount() {
			return 3;
		}
	},
	XUV{
		@Override
		public int getAvailableSeatCount() {
			return 5;
		}
	},
	Most_Vacant{
		@Override
		public int getAvailableSeatCount() {
			return 4;
		}
	};
}
