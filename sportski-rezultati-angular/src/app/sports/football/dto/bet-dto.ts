import { BetValueDto } from "./bet-value-dto";

export class BetDto {
    id: Number | undefined;
    name: String | undefined;
    values: BetValueDto[] = [];
    selected?: String;
}
