CREATE UNIQUE INDEX IF NOT EXISTS ux_loans_active_item
    ON loans (publication_item_id)
    WHERE returned_at IS NULL