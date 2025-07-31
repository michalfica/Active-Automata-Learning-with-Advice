import copy, pandas as pd


class Tables:

    def __init__(self):
        pass

    def create_basic_table(self, columns, data, reduction_column=("Reduction", "EQ")):
        columns = pd.MultiIndex.from_tuples(columns)
        df = pd.DataFrame(data, columns=columns)

        avg_eq_red = df[(reduction_column)].mean()
        max_eq_red = df[(reduction_column)].max()
        min_eq_red = df[(reduction_column)].min()
        empty_row = pd.DataFrame([[""] * df.shape[1]], columns=df.columns)

        def set_params(row, params):
            for k, v in params:
                row[columns[k]] = v

        max_red_row = copy.deepcopy(empty_row)
        set_params(
            row=max_red_row, params=[(0, "Max reduction"), (-1, int(max_eq_red))]
        )
        min_red_row = copy.deepcopy(empty_row)
        set_params(
            row=min_red_row, params=[(0, "Min reduction"), (-1, int(min_eq_red))]
        )
        avg_red_row = copy.deepcopy(empty_row)
        set_params(
            row=avg_red_row, params=[(0, "Average reduction"), (-1, int(avg_eq_red))]
        )

        rows = [empty_row, max_red_row, min_red_row, avg_red_row]
        for row in rows:
            df = pd.concat([df, row], ignore_index=True)

        df[reduction_column] = df[reduction_column].apply(
            lambda x: f"{x}%" if isinstance(x, int) else x
        )

        return df

    def create_table_conv_with_cl(
        self, columns, data, common_letters, number_of_iter_per_case
    ):
        columns = pd.MultiIndex.from_tuples(columns)
        df = pd.DataFrame(data, columns=columns)

        avg_eq_red = df[(("Reduction", "EQ"))].mean()
        max_eq_red = df[(("Reduction", "EQ"))].max()
        min_eq_red = df[(("Reduction", "EQ"))].min()
        empty_row = pd.DataFrame([[""] * df.shape[1]], columns=df.columns)

        def set_params(row, params):
            for k, v in params:
                row[columns[k]] = v

        max_red_row = copy.deepcopy(empty_row)
        set_params(
            row=max_red_row, params=[(0, "Max reduction"), (-1, int(max_eq_red))]
        )
        min_red_row = copy.deepcopy(empty_row)
        set_params(
            row=min_red_row, params=[(0, "Min reduction"), (-1, int(min_eq_red))]
        )
        avg_red_row = copy.deepcopy(empty_row)
        set_params(
            row=avg_red_row, params=[(0, "Average reduction"), (-1, int(avg_eq_red))]
        )

        rows = [empty_row, max_red_row, min_red_row, avg_red_row]
        for row in rows:
            df = pd.concat([df, row], ignore_index=True)

        for i in range(len(common_letters)):
            df = pd.concat(
                [
                    df.iloc[: (i + 1) * number_of_iter_per_case + i],
                    empty_row,
                    df.iloc[(i + 1) * number_of_iter_per_case + i :],
                ]
            ).reset_index(drop=True)

        df[("Reduction", "EQ")] = df[("Reduction", "EQ")].apply(
            lambda x: f"{x}%" if isinstance(x, int) else x
        )
        df[("Common letters")] = df[("Common letters")].apply(
            lambda x: f"{x}%" if isinstance(x, int) else x
        )

        return df
